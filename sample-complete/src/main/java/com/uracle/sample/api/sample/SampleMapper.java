package com.uracle.sample.api.sample;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {

    Integer insertSample(Sample sample);
    Sample selectSampleById(Sample sample);
    List<Sample> selectSamples();
    Integer updateSample(Sample sample);
    Integer deleteSample(Sample sample);
}
