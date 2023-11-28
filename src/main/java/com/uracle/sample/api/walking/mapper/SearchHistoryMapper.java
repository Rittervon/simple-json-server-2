package com.uracle.sample.api.walking.mapper;

import java.util.List;

import com.uracle.sample.api.walking.table.SearchHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SearchHistoryMapper {

    /*################## SearchHistory #####################*/
    Integer insertSearchHistory(SearchHistory searchHistory);
    List<SearchHistory> selectSearchHistory();
    Integer deleteSearchHistory(SearchHistory searchHistory);
}
