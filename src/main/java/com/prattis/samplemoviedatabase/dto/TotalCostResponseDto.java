package com.prattis.samplemoviedatabase.dto;

import com.prattis.samplemoviedatabase.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Data transfer object (DTO) representing the response for the product total cost calculation.
 * Contains the product ID and the total cost of the product.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TotalCostResponseDto {
	private long id;
	private BigDecimal totalCost;
	private Product product;
	
	public static TotalCostResponseDto createDto(Product product, BigDecimal totalCost) {
		return TotalCostResponseDto.builder()
				.id(product.getId())
				.totalCost(totalCost)
				.product(product)
				.build();
	}
}
