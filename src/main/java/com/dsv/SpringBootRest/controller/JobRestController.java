package com.dsv.SpringBootRest.controller;

import com.dsv.SpringBootRest.model.JobPost;
import com.dsv.SpringBootRest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    JobService service;

//    @GetMapping(path="jobPosts", produces="application/json") //content negotiation i.e. accepting data only xml format
    @GetMapping("jobPosts")
    @ResponseBody
    public List<JobPost> getAllJobs(){
        return service.getJobs();
    }

    @GetMapping("jobPosts/{postId}")
    public JobPost getJob(@PathVariable int postId){ //To make sure to look for the variable attain from http = path variable
        return service.getJob(postId);
    }

    @PostMapping(path="jobPost", consumes = "application/json") //server will accepts only json data
    public void addJob(@RequestBody  JobPost jobPost){
        service.addJob(jobPost);
    }

    @PutMapping("jobPost")
    public JobPost update(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String delete(@PathVariable int postId){
        service.deleteJob(postId);
        return "Deleted";
    }

    @GetMapping("load")
    public String load(){
        service.load();
        return "success";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> search(@PathVariable("keyword") String keyword){
        return service.searchByKeyword(keyword);    
    }
}
