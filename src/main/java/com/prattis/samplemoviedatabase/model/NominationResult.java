package com.prattis.samplemoviedatabase.model;

import com.prattis.samplemoviedatabase.model.enums.NominationResultType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class NominationResult {
	@ManyToOne
	@MapsId("actorId")
	public Actor actor;
	@ManyToOne
	@MapsId("nominationId")
	public Nomination nomination;
	@EmbeddedId
	private NominationResultId nominationResultId = new NominationResultId();
	@Column(name = "nomination_result_type")
	private NominationResultType nominationResultType;
}
