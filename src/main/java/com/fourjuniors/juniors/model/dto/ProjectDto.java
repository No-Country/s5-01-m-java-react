package com.fourjuniors.juniors.model.dto;

import com.fourjuniors.juniors.model.entity.Image;
import lombok.Builder;
import lombok.Data;

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
