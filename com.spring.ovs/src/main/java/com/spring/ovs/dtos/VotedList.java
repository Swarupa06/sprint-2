package com.spring.ovs.dtos;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.spring.ovs.dtos.CooperativeSociety;
import com.spring.ovs.dtos.RegisteredSocietyVoters;
@Entity
@Table(name = "ovs")
public class VotedList {

	@Id
	@GeneratedValue
	
	@Column(name = "id")
	private int id;
	
	@Column(name="pollingDateTime")
	@DateTimeFormat(pattern="dd-mm-yyyy")
	private Date pollingDateTime;
	
	//@Column(name="society")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="societyId")
	private CooperativeSociety society;
	
	//@Column(name="voter")
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="voterId")
	private RegisteredSocietyVoters voter;
	
	//@Column(name="candidate")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="candidateId")
	
    private  NominatedCandidates candidate;
	
	
	
	
	
	public VotedList() {
		// TODO Auto-generated constructor stub
		super();
	}

	public VotedList(Date pollingDateTime ,CooperativeSociety society,RegisteredSocietyVoters voter, NominatedCandidates candidate) {
		super();
		this.pollingDateTime = pollingDateTime;
		this.society = society;
		this.voter = voter;
		this.candidate=candidate;
		
		
	}

	public VotedList(int id, Date pollingDateTime ,CooperativeSociety society,RegisteredSocietyVoters voter, NominatedCandidates candidate) {
		super();
		this.id = id;
		this.pollingDateTime = pollingDateTime;
		this.society = society;
		this.voter = voter;
		this.candidate=candidate;
		
	}




	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPollingDateTime() {
		return pollingDateTime;
	}

	public void setPollingDateTime(Date pollingDateTime) {
		this.pollingDateTime = pollingDateTime;
	}

	public CooperativeSociety getSociety() {
		return society;
	}

	public void setSociety(CooperativeSociety society) {
		this.society = society;
	}

	public NominatedCandidates getCandidate() {
		return candidate;
	}

	public void setCandidate(NominatedCandidates candidate) {
		this.candidate = candidate;
	}

	public RegisteredSocietyVoters getVoter() {
		return voter;
	}

	public void setVoter(RegisteredSocietyVoters voter) {
		this.voter = voter;
	}
	
	

	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("VotedList{");
		sb.append("id:").append(id).append(",");
		sb.append("pollingDateTime:").append(pollingDateTime).append(",");
		sb.append("society:").append(society).append(",");
		sb.append("candidate:").append(candidate).append(",");
		sb.append("voter:").append(voter).append(",");
		sb.append("}");
		
		return sb.toString();
	}

	
	

}
