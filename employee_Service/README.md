# spring-boot-jpa-RestAPI

Different Layers 

    @Controller
    public class EmployeeController 


    @Service
    public class EmplomentServiceImpl implements EmplomentService 

    @Repository
    public interface EmployeeRepository extends CrudRepository<Employee, Long> 


    @EnableDiscoveryClient
    public class Application 

