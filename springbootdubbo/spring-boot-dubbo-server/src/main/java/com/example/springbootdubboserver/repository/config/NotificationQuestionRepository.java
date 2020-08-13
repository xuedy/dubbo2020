package com.example.springbootdubboserver.repository.config;

import com.example.springbootdubboserver.entity.config.HealthQuestionsConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationQuestionRepository extends JpaRepository<HealthQuestionsConfig,Long> {

}
