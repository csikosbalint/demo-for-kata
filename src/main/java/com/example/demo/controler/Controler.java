package com.example.demo.controler;

import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Recept;
import com.example.demo.model.ReceptRepository;
import com.example.demo.model.User;
import com.example.demo.model.UserRepository;

@RestController
public class Controler {
    private ReceptRepository receptRepository;
    private UserRepository userRepository;

    @Autowired
    public Controler(ReceptRepository receptRepository, UserRepository userRepository) {
        this.receptRepository = receptRepository;
        this.userRepository = userRepository;
        User user = new User();
        user.setName("admin");
        user.setFName("alma");

        this.userRepository.save(user);
        Recept r = new Recept();
        r.setUser(user);
        this.receptRepository.save(r);

        System.out.println("-1-");
        for ( Recept recepet: this.receptRepository.findAll() ) {
            System.out.println(recepet.getUser().getFname());
        }
        System.out.println("---");

        User u = this.userRepository.findByFname("alma").get();
        u.setFName("cica");
        this.userRepository.save(u);

        System.out.println("-2-");
        for ( Recept recepet: this.receptRepository.findAll() ) {
            System.out.println(recepet.getUser().getFname());
        }
        System.out.println("---");
    }

    @RequestMapping("/test")
    public String test() {
        Recept recept = new Recept();
        User user = this.userRepository.findByFname("cica").get();
        recept.setUser(user);
        this.receptRepository.save(recept);
        return "cica\n";
    }
}