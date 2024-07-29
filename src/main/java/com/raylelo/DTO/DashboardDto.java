package com.raylelo.DTO;

import java.util.List;

import com.raylelo.model.Jobs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardDto {	
	List<TileDto> tiles;
	List<Jobs> results;
	List<Jobs> admitCards;
	List<Jobs> latestJobs;
}
