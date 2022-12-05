package com.fourjuniors.juniors.service;

import com.fourjuniors.juniors.model.dto.ImageDto;
import com.fourjuniors.juniors.model.entity.Image;

public interface ImageService {

    Image saveImage(ImageDto request);
}
