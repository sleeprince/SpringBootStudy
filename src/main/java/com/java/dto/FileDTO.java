package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileDTO {
	
	private int no;
	private int type;
	private String domain;
	private String path;
	private int del;
	private int cnt;
}
