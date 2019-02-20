ErVerifyTool
============

This is a verification tool for checking the conformity of an evidence record
to the requirements of TR-ESOR-ERS 1.2.


Project Structure
-----------------

Project is based on Gradle and contains the following sub-projects:

* _commons_ - the verify tool itself
* _cli_ - main class and packaging as command line tool (and standalone web
  service)
* _war_ - packaging as web application (war-file) for deployment on Apache
  Tomcat

How to use the project with Eclipse:

* call "gradle compileJava" in projects main directory
* in Eclipse: call "Import/Gradle/Existing Gradle Project" (requires Buildship
  Gradle Integration)


Documentation
-------------

Is generated by [Sphinx](http://www.sphinx-doc.org). For information how to
generate the documentation see file ``doc/README.md``.


Release Bundle
--------------

To build a release bundle call this on top level:

	gradle clean build -Prelease

This will also generate the documentation using some external tools
(sphinx, latex). If these tools are not installed use the following call to
skip document generation:

	gradle clean build -P release --continue

This will cause an incomplete release without documentation.

The releases archive can then be found in the ``all`` sub-project.


Manual Testing
--------------

Follow the instructions in the product documentation for installation and
usage.


Automatic Tests
-----------------

Unit tests and integration tests are in the build phases "test" and
"integration-test", respectively. Call

	gradle test

to build the project and do the tests and

	gradle build

to execute integration tests and verify phase in addition. Note that the
integration tests require an eCard web service with Verify support, to be
specified in the default test configuration
(``commons/src/test/resources/config.xml``) as eCardURL parameter for the
online_profile:

    <Profile name="online_profile">
        ...
        <parameter name="eCardURL">http://server/eCard/eCard?wsdl</parameter>

As usually, specifying -DskipTests will make gradle skip all tests.
Analogously, you may specify -DskipUnitTests or -DskipIntegrationTests to skip
only the unit tests or only the integration tests.