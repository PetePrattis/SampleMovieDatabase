package com.prattis.samplemoviedatabase.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NominationResultId implements Serializable {
	private long actorId;
	private long nominationId;
}
