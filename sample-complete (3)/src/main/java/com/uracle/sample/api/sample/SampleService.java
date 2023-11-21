package com.uracle.sample.api.sample;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SampleService {

    @Autowired
    private SampleMapper sampleMapper;

    public int insertSample(Sample sample) {
        int affectRow = sampleMapper.insertSample(sample);
        logger.debug("insert count: {}", affectRow);

        return affectRow;
    }


    public List<Sample> selectSamples() {
        List<Sample> samples = sampleMapper.selectSamples();
        logger.debug("select count: {}", samples.size());

        for (Sample sample : samples) {
            logger.debug(">>>> sample: {}", sample);
        }

        return samples;
    }

    public Sample selectSampleById(Sample param) {
        Sample sample = sampleMapper.selectSampleById(param);
        if (sample == null) {
            sample = new Sample();
        }
        logger.debug("sample: {}", sample);

        return sample;
    }

    public int updateSample(Sample param) {
        int affectRow = sampleMapper.updateSample(param);
        logger.debug("update count: {}", affectRow);

        return affectRow;
    }

    public int deleteSample(Sample param) {
        int affectRow = sampleMapper.deleteSample(param);
        logger.debug("delete count: {}", affectRow);

        return affectRow;
    }
}
