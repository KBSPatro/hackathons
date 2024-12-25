package com.bhabani.flexiventures.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhabani.flexiventures.models.Order;
import com.bhabani.flexiventures.services.OrderService;

@RestController
@RequestMapping("/flexiventures")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping("/list")
	private List<Order> get() {
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();

		for (SimpleGrantedAuthority simpleGrantedAuthority : authorities) {
			if (simpleGrantedAuthority.getAuthority().equals("ROLE_PUBLISHER")
					|| simpleGrantedAuthority.getAuthority().equals("ROLE_REVIEWER"))
				return orderService.get().stream().filter((order) -> order.getStatus().equals("created")
						|| order.getStatus().equals("rework") || order.getStatus().equals("reworked")).toList();
			else if (simpleGrantedAuthority.getAuthority().equals("ROLE_APPROVER"))
				return orderService.get().stream().filter((order) -> order.getStatus().equals("reviewed")).toList();
		}
		return null;
	}

	@PostMapping("/txn")
	private Order save(@RequestBody Order order) {
		order.setStatus("created");
		order.setCreatedBy(getUsername());

		return orderService.save(order);
	}

	@PatchMapping("/txn")
	private Order update(@RequestBody Order order) {
		List<Order> orders = orderService.get();
		for (Order order1 : orders)
			if (order1.getRecordId().equals(order.getRecordId())) {
				order1.setStatus(order.getStatus());
				order1.setUpdatedBy(getUsername());

				return order1;
			}

		return null;
	}

	private String getUsername() {
		String username = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		return username;
	}
}
