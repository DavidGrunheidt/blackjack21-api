package com.dvosoftwarehouse.blackjack21.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name = "player")
public class Player {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_id_seq")
  @GenericGenerator(
      name = "player_id_seq",
      strategy = "com.vladmihalcea.hibernate.id.BatchSequenceGenerator",
      parameters = {
          @Parameter(name = "sequence", value = "player_id_seq"),
          @Parameter(name = "fetch_size", value = "5")
      })
  @NonNull
  private Long id;

  @Column(name = "email", unique = true, nullable = false)
  @NonNull
  private String email;

  @Column(name = "username", length = 40, unique = true, nullable = false)
  @NonNull
  private String username;

  @Column(name = "display_name", length = 20, nullable = false)
  @NonNull
  private String displayName;

  @Column(name = "created_at", nullable = false, updatable = false)
  @NonNull
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;
}
