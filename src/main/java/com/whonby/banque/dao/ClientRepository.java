package com.whonby.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whonby.banque.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
