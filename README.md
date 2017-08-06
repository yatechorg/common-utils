[![Build Status](https://travis-ci.org/yatechorg/common-utils.svg)](https://travis-ci.org/yatechorg/common-utils)
[![Download](https://api.bintray.com/packages/yatech/maven/common-utils/images/download.svg)](https://bintray.com/yatech/maven/common-utils/_latestVersion)
[![Coverage Status](https://coveralls.io/repos/yatechorg/common-utils/badge.svg?branch=master&service=github)](https://coveralls.io/github/yatechorg/common-utils?branch=master)
[![Sputnik](https://sputnik.ci/conf/badge)](https://sputnik.ci/app#/builds/yatechorg/common-utils)

# common-utils
A collection of common Java utilities.  
See [Wiki](https://github.com/yatechorg/common-utils/wiki) for more details and documentation.

## Highlights

### *requireX* - Argument Requirements
A set of argument requirement methods, based on the form of the `Objects.requireNonNull` methods introduced in JDK 8. For example:

```java
public class Person {
  private final String name;
  private final int age;

  public Person(String name, int age) {
    this.name = StringArgs.requireNonBlank(name, "Person name is required");
    this.age = NumericArgs.requireNonNegative(age, "Person age must be non-negative");
  }
}
```

See more details in the [requireX](https://github.com/yatechorg/common-utils/wiki/requireX---Argument-Requirements) wiki page.
