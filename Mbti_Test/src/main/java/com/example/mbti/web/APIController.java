package com.example.mbti.web;

import com.example.mbti.domain.Mbti.Mbti;
import com.example.mbti.service.MbtiService;
import com.example.mbti.service.QuestionService;
import com.example.mbti.web.dto.Question.QuestionResponseDto;
import com.example.mbti.web.dto.Question.QuestionSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Controller
public class APIController {
    private final QuestionService questionService;
    private final MbtiService mbtiService;
    private Mbti mbti;
    private int recent=-1;

    @PostConstruct
    public void init(){
        //질문 미리 등록
        for(int i=0;i<3;i++){
            QuestionSaveRequestDto requestDto0 = new QuestionSaveRequestDto(1,0,0,0, "질문1");
            questionService.save(requestDto0);
        }
        for(int i=0;i<3;i++){
            QuestionSaveRequestDto requestDto0 = new QuestionSaveRequestDto(0,1,0,0, "질문2");
            questionService.save(requestDto0);
        }
        for(int i=0;i<3;i++){
            QuestionSaveRequestDto requestDto0 = new QuestionSaveRequestDto(1,0,1,0, "질문3");
            questionService.save(requestDto0);
        }
        for(int i=0;i<3;i++){
            QuestionSaveRequestDto requestDto0 = new QuestionSaveRequestDto(1,0,0,1, "질문4");
            questionService.save(requestDto0);
        }

        mbti = new Mbti(0, 0, 0, 0, "");
    }

    @GetMapping("/test")
    public String index(){
        return "index";
    }

    @GetMapping("/test/{id}")
    public String start_test(@PathVariable Long id, Model model){
        if(recent!=-1){
            if(id>1 && id<=4){
                //2,3,4
                mbti.setEI(mbti.getEI()-recent);
            }else if(id>4 && id<=7){
                //5,6,7
                mbti.setSN(mbti.getSN()-recent);
            }else if(id>7 && id<=10){
                //8,9,10
                mbti.setTF(mbti.getTF()-recent);
            }else{
                //11,12
                mbti.setJP(mbti.getJP()-recent);
            }
        }
        QuestionResponseDto dto = questionService.findById(id);
        model.addAttribute("questionDto",dto);
        return "test";
    }

    @PostMapping("/test/{id}")
    public String test2(@PathVariable Long id, @RequestParam("EI") String EI, Model model){
        recent = Integer.parseInt(EI);

        if(id>1 && id<=4){
            //2,3,4
            mbti.setEI(mbti.getEI()+recent);
            System.out.println(mbti.getEI());
        }else if(id>4 && id<=7){
            //5,6,7
            mbti.setSN(mbti.getSN()+recent);
            System.out.println(mbti.getSN());
        }else if(id>7 && id<=10){
            //8,9,10
            mbti.setTF(mbti.getTF()+recent);
            System.out.println(mbti.getTF());
        }else{
            //11,12
            mbti.setJP(mbti.getJP()+recent);
            System.out.println(mbti.getJP());
        }
        QuestionResponseDto dto = questionService.findById(id);
        model.addAttribute("questionDto", dto);
        return "test";
    }
}
