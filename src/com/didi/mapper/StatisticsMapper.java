package com.didi.mapper;


import java.util.List;
import java.util.Map;


public interface StatisticsMapper {
  

	List<String> getDevcieIdList(Map<String, Object> paramMap);

	Map<String, Object> moneyStatistics(Map<String, Object> paramMap);
	
} 