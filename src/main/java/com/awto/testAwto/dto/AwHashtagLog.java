package com.awto.testAwto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AwHashtagLog {

	private Integer logId;

	private Integer hashtagId;
}
