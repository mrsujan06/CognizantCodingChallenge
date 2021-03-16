Cognizant Android Developer Task

Application is structured in MVVM Architecture. I have used this Architecture mainly for separation of concerns, maintainability and scalability and also it is my favourite Architecture.
In this application I have used one Activity (MainActivity) and two fragments (LoginFragment and ListFragment). LoginFragment requires user to enter email and password. Email must be format of email i.e.   (mrsujan06@gmail.com)  and Password must contain minimum eight characters, at least one letter and one number i.e.  (london123) 

When login button is clicked it checks for login validations. Login validation logic is inside LoginViewModel. If user have entered valid email and password user is navigated to ListFragment which contain list of super heroes. I used 
Navigation component to fulfil this action. To display list of items I used library called Groupie. Using Groupie, I didn't have to create adapter class for the list of items as it already comes with adapter called Groupie Adapter. It is easy and convenient library to use and also it supports view binding.

For dependency injection I have used library called Hilt. Hilt makes it very easy to decouple the creation and usages of an object. It is easy to setup. I used hilt to provide Repository and DataSource class object.
DataSource class contain hard coded list of super heroes which is used by repository. Viewmodel gets the list of super heroes’ data from the repository and data in wrapped into LiveData so that the list could be observed from ListFragment and is displayed in RecyclerView. I also have used view binding; it makes easy to interacts with views.
