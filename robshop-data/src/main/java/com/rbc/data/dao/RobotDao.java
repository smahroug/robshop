package com.rbc.data.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rbc.data.model.Robot;

@Repository
public interface RobotDao extends JpaRepository<Robot, Long> {


}
