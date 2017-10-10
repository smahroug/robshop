package com.rbc.test;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.rbc.data.config.DataConfig;
import com.rbc.data.model.Robot;
import com.rbc.service.config.ServiceConfig;
import com.rbc.service.robot.RobotService;

import static org.assertj.core.api.Assertions.assertThat;




@RunWith(SpringRunner.class)
@SpringBootTest(classes={ServiceConfig.class, DataConfig.class})
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@DataJpaTest
@Transactional
public class TestService {
	
	private static final Long EXISTENT_ROBOT_ID = 1L;
	
	@Autowired
	private RobotService robotService;
	
	@Test
	public void testFindRobot(){
		assertThat(robotService.findRobot(EXISTENT_ROBOT_ID)).isNotNull();
	}
	
	@Test
	public void testFindAllRobot(){
		assertThat(robotService.findAllRobots()).isNotEmpty();
	}
	
	@Test
	public void testCreateRobot(){
		Robot robotToCreate = createRobotForTest();
		Robot savedRobot = robotService.saveRobot(robotToCreate);
		assertThat(savedRobot.getId()).isNotNull();
		
	}
	
	@Test
	public void testUpdateRobot(){
		String fieldToUpdate = "Updated";
		Robot robotToUpdate = robotService.findRobot(EXISTENT_ROBOT_ID);
		robotToUpdate.setDescription(fieldToUpdate);
		Robot updatedRobot = robotService.saveRobot(robotToUpdate);
		assertThat(updatedRobot.getDescription().equalsIgnoreCase(fieldToUpdate));
	}
	
	@Test
	public void testDeleteRobot(){
		robotService.deleteRobot(EXISTENT_ROBOT_ID);
		Robot noRobotHere = robotService.findRobot(EXISTENT_ROBOT_ID);
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
