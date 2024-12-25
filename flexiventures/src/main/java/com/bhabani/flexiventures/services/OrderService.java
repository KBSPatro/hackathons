package com.bhabani.flexiventures.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bhabani.flexiventures.models.Order;

@Service
public class OrderService {
	private List<Order> list;

	public OrderService() {
		list = new ArrayList<>();
	}

	public List<Order> get() {
		return this.list;
	}

	public Order save(Order order) {
		this.list.add(order);
		return order;
	}
}
