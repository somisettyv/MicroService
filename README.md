# MicroService


GateWay

    Add the Following Annotation to Springboot Application Class
    
          @EnableZuulProxy
          
    Add the Routes as follows to route the calls to appropriate Micro Service
       
          zuul:
              prefix: /api
              routes:
                account: 
                  path: /dept/**
                  serviceId: department-service
                customer: 
                  path: /employee/**
                  serviceId: employee-service        

            ribbon:
              eureka:
                enabled: true

            eureka:
              client:
                serviceUrl:
                  defaultZone: http://localhost:8761/eureka/
                registerWithEureka: false       

    
Eureka Server(Naming Server)
	
    Add the Following Annotation to Springboot Application Class


    @SpringBootApplication
      @EnableEurekaServer 
Micro Services :
   
   Department Service
   
    //Add the eureka URL as follows so that this will register 
    server.port=9094
    spring.application.name=department-service
    eureka.client.service-url.default-zone=http://localhost:8761/eureka


    Employee Service

    server.port=9093
    spring.application.name=employee-service
    eureka.client.service-url.default-zone=http://localhost:8761/eureka
    
    
    Start all the Applications 
    
    Make a Rest Call follows 
    
    
    http://localhost:8765/api/dept/org/dept/     --> Make call with Zuul URL that will be routed to  Eureka -> Department Or Employer Service
    
    
          [
          {
              "number": 2,
              "name": "IT",
              "location": "Philly"
          }
         ]
   
   
     http://localhost:8765/api/employee/org/dept/1
     
        
     
   
