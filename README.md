## Java Simple Backend Application 

### Project Goal

 - Create a series of classes which can filter and sort a list of `User Post` objects. This will form part of the 

### Skills

- Writing Java code
- Unit testing for Java
- Introduction to Object Oriented
- Debugging in IntelliJ

### Getting Started
- Clone the repository to a Dev location (for example `C:\Dev\posting-sorting-grad-project`)
- Install [IntelliJ Community](https://www.jetbrains.com/idea/download/)
- Create a new folder inside of the root folder (`~\posting-sorting-grad-project`) called `out`. 
  - Note that this folder and all contents are ignored by git
- Open the root folder  in IntelliJ
  - Notice that a folder called `.idea` has been created in your project, the contents of this folder have been marked as git ignored
- Setup the JDK (java software development kit) from the hint at the top of IntelliJ. The installation should come with JDK 11
- In the project explorer, right click the source folder and choose "Mark Directory as > Sources Root"
  - This should now show the `Main` and `UserPost` classes as java classes
- Run the application by clicking the play button or by going to "Run > Run 'Main'"
  - This may fail if it cannot find an out folder or if the language setting isn't compatible with the java SDK running
- Look at the Run window for a list of the example posts

### Tasks

> The following tasks are intended to be completed without the use of java streams

- Create a new class called `AuthorPostSorter` which implements the PostSorter interface. Write the implementation for its sort method which returns the list of user posts in order of author name alphabetically ascending
- To test the functionality we want to add JUnit as a testing framework. Although dependencies _could_ be added directly as a packaged `jar` this isn't very portable. Instead, we need a little more help in the project structure so this is a good opportunity to convert the project to [Maven](https://www.jetbrains.com/help/idea/convert-a-regular-project-into-a-maven-project.html).
  - By default Maven relies on a master `pom` which assumes that the java language is 5. To fix this we need to add a couple of extra settings the project's `pom.xml`. See [pom_fragment.tst](pom_fragment.txt)
- Once we have JUnit set up add unit tests to confirm the behaviour of your `AuthorPostSorter` (Hint: right click the name of the class in IntelliJ and click "generate > unit tests"). You should check that the method can sort user posts by author name without case sensitivity and that the method can cope with bad input - e.g. a `null` or empty input list.
  - **For the remainder of this project you should include new unit tests in addition to every new method/change in behaviour added to classes**
- The `SortOrder` enum has been included in the solution. Adjust the PostSorter interface so that the sort method can be sorted in ascending or descending order and edit the `AuthorPostSorter` and tests accordingly
- Write classes which each provide a method for sorting by:
  - Date submitted
  - Number of likes
  - Length of content in post
  - Author name extended - if a surname is provided, sort by surname, otherwise sort by first name.
- Write a new interface called `PostFilter` for classes that can filter an input list and return a reduced list. Write classes which can filter by:
  - Author
  - Keyword in post content
  - Posts made between certain dates
  - Only posts which have likes
- Write classes for combining filters using AND and OR, for example can filter to return only posts made in "2019" or by someone named "Amy"
  - Hint: many Scott Logic interviewers can help with this task...
- Write new classes which leverage multiple sort/filters:
  - Name and then date posted
  - Keyword - Given a keyword return the posts ordered by the number of times the keyword appears in the `Post` content
- Write a new class which will extract topics from `Post` content using regex or otherwise (unit tests should be agnostic to the implementation here). Here we are considering a topic as a keyword that is used multiple times.
  - Write a method to group user posts into a topic and return the list sorted by supposed topics
- Write an over-arching `UserPostService` which exposes the various methods for sorting and filtering using the classes above.


### Extension Tasks

- Write a class which can take a JSON representation of a filter and sort method and produce the runtime filter/sort for this
- Rewrite the above sort and filter classes using java streams. All unit tests should be unaffected