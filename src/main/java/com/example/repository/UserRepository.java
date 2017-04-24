package com.example.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

@Repository
public interface UserRepository extends CassandraRepository<User> {

}
