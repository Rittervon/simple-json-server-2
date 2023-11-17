package com.uracle.sample.api.walking.service;

import com.uracle.sample.api.walking.mapper.SearchHistoryMapper;
import com.uracle.sample.api.walking.table.SearchHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service

public class SearchHistoryService {
    @Autowired
    private SearchHistoryMapper searchHistoryMapper;

    public int insertSearchHistory(SearchHistory searchHistory){
        int affectRow = searchHistoryMapper.insertSearchHistory(searchHistory);
        logger.debug("insert count: {}", affectRow);

        return affectRow;
    }

    public List<SearchHistory> selectSearchHistory() {
        List<SearchHistory> searchHistories = searchHistoryMapper.selectSearchHistory();
        logger.debug("select count: {}", searchHistories.size());

        for (SearchHistory searchHistory : searchHistories) {
            logger.debug(">>>> user: {}", searchHistory);
        }

        return searchHistories;
    }

    public int deleteSearchHistory(SearchHistory param) {
        int affectRow = searchHistoryMapper.deleteSearchHistory(param);
        logger.debug("delete count: {}", affectRow);

        return affectRow;
    }
}
