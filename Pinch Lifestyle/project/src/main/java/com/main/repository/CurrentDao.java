package com.main.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.main.entity.Current;

public interface CurrentDao extends JpaRepository<Current, Integer>{

	@Modifying
	@Transactional
	@Query(value = "delete from Current c where c.id = :id")
	public void del(int id);
}
