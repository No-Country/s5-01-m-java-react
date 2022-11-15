package com.fourjuniors.juniors.dto;

import com.fourjuniors.juniors.entity.Image;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder

public class ProjectDto {
    private String projectname;

    private String projectdescription;

    private String projectmembers;

    private Image projectimage;

    private String projectlinkrol;

    private String projectlink;

    private String projectstack;

    private String projecttype;

}
