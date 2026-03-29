package com.github.apz.sample.constraints;

import jakarta.validation.GroupSequence;

@GroupSequence({StaticValidators.class, DynamicValidator.class})
public interface ValidationOrder {

}
