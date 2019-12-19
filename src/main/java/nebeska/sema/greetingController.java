package nebeska.sema;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class greetingController {

  @GetMapping("/greeting")
  JSONArray all() {
	  JSONParser pars = new JSONParser();
	  JSONArray a = new JSONArray();
      try (FileReader reader = new FileReader("employee.json")){
          Object obj = pars.parse(reader);

          JSONArray employeeList = (JSONArray) obj;
          System.out.println(employeeList);
          //Iterate over employee array
          a =employeeList;
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      } catch (ParseException e) {
          e.printStackTrace();
      }
    return a;
  }

  @PostMapping("/greeting")
  String newEmployee(@RequestBody JSONObject newEmployee) throws IOException {
	  
	  
	  JSONParser pars = new JSONParser();
		 JSONArray employeeList = new  JSONArray();
	      try (FileReader reader = new FileReader("employee.json")){
	          Object obj = pars.parse(reader);

	          employeeList = (JSONArray) obj;
	          System.out.println(employeeList);
	          //Iterate over employee array
	      } catch (FileNotFoundException e) {
	          e.printStackTrace();
	      } catch (IOException e) {
	          e.printStackTrace();
	      } catch (ParseException e) {
	          e.printStackTrace();
	      }
		  
		  
		  employeeList.add(newEmployee);
		  			
		  try (FileWriter file = new FileWriter("employee.json")) {
				file.write(employeeList.toJSONString());
				file.flush();  
				file.close(); 
				}
		  System.out.println(employeeList);
		  
		  return "ok";
  }

  // Single item

  @GetMapping("/greeting/{id}")
  Object getSpec(@PathVariable int id) {
	  JSONParser pars = new JSONParser();
		 JSONArray employeeList = new  JSONArray();
	      try (FileReader reader = new FileReader("employee.json")){
	          Object obj = pars.parse(reader);

	          employeeList = (JSONArray) obj;
	          System.out.println(employeeList);
	          //Iterate over employee array
	      } catch (FileNotFoundException e) {
	          e.printStackTrace();
	      } catch (IOException e) {
	          e.printStackTrace();
	      } catch (ParseException e) {
	          e.printStackTrace();
	      }
		return employeeList.get(id);
	      
	      
    
  }
  
  @PutMapping("/greeting/{id}")
  String update(@PathVariable int id, @RequestBody JSONObject newEmployee) throws IOException {
	  JSONParser pars = new JSONParser();
		 JSONArray employeeList = new  JSONArray();
	      try (FileReader reader = new FileReader("employee.json")){
	          Object obj = pars.parse(reader);

	          employeeList = (JSONArray) obj;
	          System.out.println(employeeList);
	          //Iterate over employee array
	      } catch (FileNotFoundException e) {
	          e.printStackTrace();
	      } catch (IOException e) {
	          e.printStackTrace();
	      } catch (ParseException e) {
	          e.printStackTrace();
	      }
	      
	      
	      
	      employeeList.set(id, newEmployee);
			
		  try (FileWriter file = new FileWriter("employee.json")) {
				file.write(employeeList.toJSONString());
				file.flush();  
				file.close(); 
				}
		  System.out.println(employeeList);
		  return "OK";
		  
  }

  /*@RequestMapping("/greeting")
  public greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    return new greeting(counter.incrementAndGet(),String.format(template, name));*/
  
}