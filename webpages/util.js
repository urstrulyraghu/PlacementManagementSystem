angular.module("studentModule",[]);
angular.module("studentModule")
    .controller("studentData",function($scope,$http){
        $http.get('http//localhost:8080/Placemets/').then(function(response){
            $scope.student = response.data;
        })
    });
angular.module("studentModule")
    .controller("studentRegister",function($http,$scope,$window){
        $scope.edQual = "";
        $scope.email = "";
        $scope.sscPercentage = "";
        $scope.intPercentage = "";
        $scope.degPercentage = "";
        $scope.name = "";
        $scope.password = "";
        $scope.addStudent = function(){
            var student = {"name":$scope.name,
                "id":$scope.id,
                "edQual":$scope.edQual,
                "email":$scope.email,
                "sscPercentage":$scope.sscPercentage,
                "intPercentage":$scope.intPercentage,
                "degPercentage":$scope.degPercentage,
                "password":$scope.password
            };
            console.log(student);
            $http.post('/placements/create/candidate',student).then(function(){
                $window.location.href="/home.html";
            },function(response){
                if(response.status==500){
                    alert("username already exists");
                }
            });
        }
    });
angular.module("studentModule")
    .controller("studentUpdate",function($http,$scope,$window){
        $http.get('/placements/candidate/sukesh').then(function(response){
            console.log(response);
            if(response.data==""){
                $window.location.href="/home.html";    
            }
            $scope.name = response.data.name;
            $scope.qualification = response.data.edQual;
            $scope.email = response.data.email;
            $scope.cgpa10 = response.data.sscPercentage;
            $scope.cgpa12 = response.data.intPercentage;
            $scope.cgpaUg = response.data.degPercentage;
            $scope.password = response.data.password;    
        },function(){
            $window.location.href="/home.html";
        });
        $scope.name = "";
        $scope.qualification = "";
        $scope.email = "";
        $scope.cgpa10 = "";
        $scope.cgpa12 = "";
        $scope.cgpaUg = "";
        $scope.modifyStudent = function(){
            var student = {"name":$scope.name,"edQual":$scope.qualification,"email":$scope.email,"sscPercentage":$scope.cgpa10,
            "intPercentage":$scope.cgpa12,"degPercentage":$scope.cgpaUg,"password":$scope.password};
            console.log(student);
            $http.put('/placements/update/candidate',student).then(function(){
                $window.location.href= '/profile.html'
           });
        }
    });
angular.module("companyModule",[]);
angular.module("companyModule")
    .controller("companyList",function($scope,$http,$window){
        $http.get("/placements/sessionCheck").then(function(response){
            if(!response.data){
                $window.location.href = "/home.html";    
            }
        },function(){
            $window.location.href = "/home.html";
        });
        $http.get("/placements/Companys").then(function(response){
            console.log(response.data);
            $scope.companies = response.data;
        });
        $scope.applyCompany = function(companyName){
            console.log(companyName);
            $http.post("/placements/apply/"+companyName).then(function(){
                /*it should be success */
            });
        }
        $scope.update = function(companyName,studentCount,year){
            var placedCandidate = {"placedCandidateId":{"year":year,"companyName":companyName},"candidateCount":studentCount,"payPackage":"0"};
            $http.post("/placements/create/placedCandidate",placedCandidate).then(function(){
                $window.location.href = "/companies.html"
            });
        }
    });
angular.module("companyModule")
    .controller("CompanyAddition",function($scope,$http){
        $scope.companyName = "";
        $scope.jobProfile = "";
        $scope.package = 0;
        $scope.dateScheduled = "";
        $scope.description = "";
        $scope.addCompany = function(){
            var company = {"name":$scope.companyName,"jobRole":$scope.jobProfile,"payPackage":$scope.package,"date":$scope.dateScheduled,"description":$scope.description};
            $http.post("/placements/create/company",company).then(function(){
                alert("added successfully");
            });
        }
    });
angular.module("loginModule",[]);
angular.module("loginModule")
    .controller("loginController",function($scope,$http,$window){
        $http.get("/placements/sessionCheck").then(function(response){
            if(response.data=="placements"){
                $window.location.href="/registerCompany.html";
            }else if(response.data==""){
                $window.location.href="/home.html";
            }else{
                $window.location.href="/profile.html";
            }
        },function(){
            $window.location.href="/home.html";
        });
        $scope.name="";
        $scope.password="";
        $scope.loginAs="";
        $scope.login = function(){
            var loginCredentials = {"username":$scope.username,"password":$scope.password};
            if($scope.loginAs==="p"){
                console.log("placement");
                $http.post("/placements/login/placement",loginCredentials).then(function(){
                    $window.location.href = "/registerCompany.html";
                },function(){
                    $window.location.href = "/home.html";
                    alert("invalid login");
                });
            }else{
                console.log("student");
                $http.post("/placements/login/candidate",loginCredentials).then(function(){
                    $window.location.href = "/profile.html";
                },function(){
                    alert("invalid Login");
                });
            }
        }
    });
angular.module("companyModule")
    .controller("logoutController",function($scope,$window,$http){
        $scope.logout = function(){
            $http.post("/placements/logout").then(function(){
                $window.location.href = "home.html";
            });
        }
    });
angular.module("companyModule")
    .controller("changePasswordController",function($scope,$window,$http){
        $http.get("/placements/sessionCheck").then(function(){
            /*
            when it is success nothing needs to be done.
            */
        },function(){
            $window.location.href="/home.html";
        });
        $scope.changePassword = function(){
            var passwords = {"currentPassword":$scope.currentPassword,"newPassword":$scope.newPassword};
            $http.post("/placements/changePassword",passwords).then(function(){
                $window.location.href = "/profile.html";
                alert("password Updated successfully");
            },function(response){
                console.log(response)
            });
        }
    });
angular.module("studentModule")
    .controller("logoutController",function($scope,$window,$http){
        $scope.logout = function(){
            $http.post("/placements/logout").then(function(){
                $window.location.href = "home.html";
            });
        }
    });
angular.module("statisticsModule",[])
    .controller("statisticsController",function($scope,$window,$http){
        $http.get("/placements/placedCandidates").then(function(response){
            $scope.items = response.data;
        });
        $scope.filter = function(){
            if($scope.yearSelected!=null){
                $http.get("/placements/placedCandidates/"+$scope.yearSelected).then(function(response){
                    if(response.data.length==0){
                        alert("data not found for this year");
                    }else{
                        $scope.items = response.data;
                    }
                });
            }
        }
    });