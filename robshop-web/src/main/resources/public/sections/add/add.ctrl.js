'use strict';
angular
    .module('app.core')
    .controller('AddController', function($scope,$routeParams,RobotService) {
        var self = this;
        
        self.robot = {};
        self.robot.id = $routeParams.id;
        loadRobot();
        self.submit = submit;
        self.createRobot = createRobot;
        self.updateRobot = updateRobot;
        self.editRobot = editRobot;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        
        function loadRobot(){
        	if(self.robot.id != null && angular.isDefined(self.robot.id)){
        		RobotService.getRobot(self.robot.id)
                .then(
                    function (robot) {
                        self.robot = robot;
                    },
                    function (errResponse) {
                        console.error('Error while loading Robot');
                        self.errorMessage = 'Error while loading Robot: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        	}
        }

        function submit() {
            console.log('Submitting');
            if (self.robot.id === undefined || self.robot.id === null) {
                console.log('Saving New Robot', self.robot);
                createRobot(self.robot);
            } else {
                updateRobot(self.robot, self.robot.id);
                console.log('Robot updated with id ', self.robot.id);
            }
        }

        function createRobot(robot) {
            console.log('About to create robot');
            RobotService.createRobot(robot)
                .then(
                    function (response) {
                        console.log('Robot created successfully');
                        self.successMessage = 'Robot created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.robot={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Robot');
                        self.errorMessage = 'Error while creating Robot: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateRobot(robot, id){
            console.log('About to update robot');
            RobotService.updateRobot(robot, id)
                .then(
                    function (response){
                        console.log('Robot updated successfully');
                        self.successMessage='Robot updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Robot');
                        self.errorMessage='Error while updating Robot '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }

        
        function removeRobot(robot){
            console.log('About to update robot');
            RobotService.removeRobot(robot)
                .then(
                    function (response){
                        console.log('Robot updated successfully');
                        self.successMessage='Robot updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Robot');
                        self.errorMessage='Error while updating Robot '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }

        function editRobot(id) {
            self.successMessage='';
            self.errorMessage='';
            RobotService.getRobot(id).then(
                function (robot) {
                    self.robot = robot;
                },
                function (errResponse) {
                    console.error('Error while removing robot ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        
        //reset Form
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.robot={};
            $scope.myForm.$setPristine(); 
        }
    


});