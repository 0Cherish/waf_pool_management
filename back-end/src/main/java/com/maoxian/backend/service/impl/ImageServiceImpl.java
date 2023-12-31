package com.maoxian.backend.service.impl;

import com.maoxian.backend.exceprion.BusinessException;
import com.maoxian.backend.mapper.ImageMapper;
import com.maoxian.backend.pojo.ImageInfo;
import com.maoxian.backend.service.ImageService;
import com.maoxian.backend.util.JsonResult;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Lin
 * @date 2023/12/30 10:04
 */
@Service
public class ImageServiceImpl implements ImageService {

    private final ImageMapper imageMapper;

    private final RestTemplate restTemplate;

    public ImageServiceImpl(ImageMapper imageMapper, RestTemplate restTemplate) {
        this.imageMapper = imageMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<ImageInfo> findImageList() {
        return imageMapper.selectList();
    }

    @Override
    public void addImage(MultipartFile image) {

        String url = "http://127.0.0.1:8081/image/upload";

        // 获取的MultipartFile文件的资源形式
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("image", image.getResource());

        // 设置请求类型
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // 将获取的MultipartFile文件放入HttpEntity中
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(multiValueMap, headers);

        ResponseEntity<JsonResult> jsonResultResponseEntity = restTemplate.exchange(url, HttpMethod.POST, request, JsonResult.class);
        JsonResult jsonResult = jsonResultResponseEntity.getBody();
        if (jsonResult == null || jsonResult.getCode() != 200) {
            throw new BusinessException("导入镜像失败");
        }
    }

    @Override
    public void deleteImageById(Long id) {
        String url = "http://127.0.0.1:8081/image/" + id;
        ResponseEntity<JsonResult> response = restTemplate.exchange(url, HttpMethod.DELETE, null, JsonResult.class);
        JsonResult jsonResult = response.getBody();
        if (jsonResult == null || jsonResult.getCode() != 200) {
            throw new BusinessException("创建waf实例失败");
        }
    }
}
