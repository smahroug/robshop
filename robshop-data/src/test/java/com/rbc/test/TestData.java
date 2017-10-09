package com.rbc.test;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.rbc.data.config.DataConfig;
import com.rbc.data.dao.RobotDao;
import com.rbc.data.model.Robot;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataConfig.class)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@DataJpaTest
@Transactional
public class TestData {
	
	private static final Long EXISTENT_ROBOT_ID = 1L;

	
	@Autowired
	private RobotDao robotDao;
	
	@Test
	public void testFindRobot(){
		assertThat(robotDao.findOne(EXISTENT_ROBOT_ID)).isNotNull();
	}
	
	@Test
	public void testFindAllRobots(){
		assertThat(robotDao.findAll()).isNotEmpty();
	}
	
	
	@Test
	public void testCreateRobot(){
		Robot robotToCreate = createRobotForTest();
		Robot savedRobot = robotDao.save(robotToCreate);
		assertThat(savedRobot.getId()).isNotNull();
		
	}
	
	@Test
	public void testUpdateRobot(){
		String fieldToUpdate = "Updated";
		Robot robotToUpdate = robotDao.findOne(EXISTENT_ROBOT_ID);
		robotToUpdate.setDescription(fieldToUpdate);
		Robot updatedRobot = robotDao.save(robotToUpdate);
		assertThat(updatedRobot.getDescription().equalsIgnoreCase(fieldToUpdate));
	}
	
	@Test
	public void testDeleteRobot(){
		robotDao.delete(EXISTENT_ROBOT_ID);
		Robot noRobotHere = robotDao.findOne(EXISTENT_ROBOT_ID);
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
