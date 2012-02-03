package utc.train;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import utc.train.dao.DemoDao;
import utc.train.pojo.Employee;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Bill
 * @version 2012-02-03
 */
@Controller
public class WelcomeController {

    @Autowired
    private DemoDao demoDao;

    @RequestMapping("/welcome.do")
    public void welcome(HttpServletRequest request) {
//        ModelAndView view = new ModelAndView("");
          request.setAttribute("name", "A san, ||" + (demoDao.test()));
    }

    @RequestMapping("/welcome/{name}.do")
    public String welcome2(@PathVariable String name, Model model) {
        List<Employee> employees = demoDao.findEmployee(name);
        model.addAttribute("name", name);
        model.addAttribute("size", employees.size());

        return "welcome";
    }

}
