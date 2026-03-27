# Persistance
 A small tool to ensure Ai works through a large document cleanly, step by step.

# Installation
Either download the source code or the **Linux** binary

# Usage
To run it, either run
```
java chatarr.java
```
for the source code or
```
./chatarr.run
```
for the binary version
Enter a prompt and a step ammount. You are then given a new prompt which you can copy-paste into an ai agent or feed it to the ai directly using open-interpreter. Then copy paste the ai's output into the Programm. This will continue until the AI worked through the entire Document or until you write 'EOF'. After some more questions, you are given a List that should answer your prompt.

# Example
"On which pages of this document does the book say 'malware'?". Make sure you include a pdf file when first prompting the ai. You should get an output like [1,3,5,7,22,25,90].

## Name
The source code and Binary file are called Chatarr due to its internal workings. If anyone wants to change it, feel free to fork the repository, change it and send in a merge request

## Contributing
If you want to contribute, just do so. I can also hand off the Repo, as it was just a tiny project created in an hour of boredom
