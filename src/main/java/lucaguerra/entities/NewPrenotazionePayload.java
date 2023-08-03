package lucaguerra.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class NewPrenotazionePayload {

	private int userId;
	private int postazioneId;
	private LocalDate data;
}
