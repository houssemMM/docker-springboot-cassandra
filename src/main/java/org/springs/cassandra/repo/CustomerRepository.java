package org.springs.cassandra.repo;

import org.springs.cassandra.model.Customer;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface CustomerRepository extends CassandraRepository<Customer, Integer> {
}
