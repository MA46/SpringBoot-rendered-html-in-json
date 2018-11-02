package ma46.rendered;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

@RestController
public class HelloController {

	@Autowired
	private ViewResolver viewResolver;

	@GetMapping("/hello")
	public String hello(HttpServletRequest request, String value) throws Exception {

		Map<String, Object> params = new HashMap<>();
		params.put("message", "Hello!" + value);

		View resolvedView = viewResolver.resolveViewName("hello", Locale.JAPANESE);
		MockHttpServletResponse response = new MockHttpServletResponse();
		resolvedView.render(params, request, response);

		String renderedHtml = response.getContentAsString();
		System.out.println(renderedHtml);

		return renderedHtml;
	}
}
