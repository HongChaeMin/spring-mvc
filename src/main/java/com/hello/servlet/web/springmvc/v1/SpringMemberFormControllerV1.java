package com.hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 스프링이 자동으로 스프링 빈으로 등록
// 스프링 MVC에서 애노테이션 기반 컨트롤러로 인식
@Controller
// @Component -> 두개 작성해서 사용해도 됨
// @RequestMapping -> 이거 하나 쓰고 직접 빈 등록해서 사용해도 됨
public class SpringMemberFormControllerV1 {

    // 요청 정보를 매핑
    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form"); // 모델과 뷰 정보를 담아서 반환
    }

}
