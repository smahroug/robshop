package com.rbc.test;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.rbc.data.model.Robot;
import com.rbc.web.config.WebConfig;
import com.rbc.web.controller.RobotController;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebConfig.class)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@WebAppConfiguration
@Transactional
public class TestController extends TestCase{
	
	private static final Long EXISTENT_ROBOT_ID = 1L;
	
	@Autowired
	private RobotController robotController;
	
	
	@Test
	public void testFindAllRobots(){
		assertThat(robotController.getRobots()).isNotEmpty();
	}
	
	@Test
	public void testFindRobot(){
		assertThat(robotController.findRobot(EXISTENT_ROBOT_ID)).isNotNull();
	}
	
	@Test
	public void testCreateRobot(){
		Robot robotToCreate = createRobotForTest();
		Robot savedRobot = robotController.createRobot(robotToCreate);
		assertThat(savedRobot.getId()).isNotNull();
		
	}
	
	@Test
	public void testUpdateRobot(){
		String fieldToUpdate = "Updated";
		Robot robotToUpdate = robotController.findRobot(EXISTENT_ROBOT_ID);
		robotToUpdate.setDescription(fieldToUpdate);
		Robot updatedRobot = robotController.updateRobot(robotToUpdate);
		assertThat(updatedRobot.getDescription().equalsIgnoreCase(fieldToUpdate));
	}
	
	@Test
	public void testDeleteRobot(){
		robotController.deleteRobot(EXISTENT_ROBOT_ID);
		Robot noRobotHere = robotController.findRobot(EXISTENT_ROBOT_ID);
		assertThat(noRobotHere).isNull();
	}
	
	private Robot createRobotForTest(){
		Robot robot = new Robot();
		robot.setDescription("Robot created by unit tests");
		robot.setName("Test Robot");
		robot.setQuantity(20L);
		return robot;
	}
	
	

}
