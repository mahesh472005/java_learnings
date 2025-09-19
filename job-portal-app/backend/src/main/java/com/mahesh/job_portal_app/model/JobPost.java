package com.mahesh.job_portal_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component

public class JobPost {

    private int id;
    private String title;
    private String company;
    private String location;
    private String desc;

}
