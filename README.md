# For Uni. Testing course.

2024-03-17

Selenium with Java.

There were three tasks. The main one is the third, where students had to run tests on jenkins. Since this course is boring af, I didn't bothered to do everything neat and clean and only made everything barely work and pass the course requirements.

This was my VERY NAIVE process:

1. Copying the dockerfile and docker compose file from peer students.
2. Running jenkins with docker compose up -d, installing default plugins.
3. Installing maven and html (somwthing) plugins
4. Creating a job - no pipeline, just a basic empty thing - then setting up chrone scheduler to run build every hour, and run the command mvn clean test -Dtest=Lab3OrAsCalledTask4OrAsCalledPart4
5. Runing the job
6. Failing
7. Checking the console
8. Realizing your life is shit
9. Running again and hoping for the best, chatting with chatgpt, fixing stuff, installing more plugins, trying other ways to create the jenkins job
10. Failing again
11. Crying
12. Asking peer students for help
13. Finding some kind of will in life.
14. Fixing everything, thinking I know where was the problem
15. Running the build
16. Failing again. Misserably
17. Crying in desperation, hating myself.
18. Putting myself together and turning on my problem-solving-thinking. Disecting the problem into steps.
19. Running the tests locally with mvn commands. Realizing i don't have installed jdk, maven, chrome, chrome driver locally.
20. Install eveything (use sudo if locally, dont use sudo if in the container):

```
apt update
apt install default-jdk maven

wget https://storage.googleapis.com/chrome-for-testing-public/122.0.6261.128/linux64/chromedriver-linux64.zip
unzip chromedriver-linux64.zip
mv chromedriver-linux64/chromedriver /usr/bin/chromedriver
chown root:root /usr/bin/chromedriver
chmod +x /usr/bin/chromedriver

wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
dpkg -i google-chrome-stable_current_amd64.deb
apt-get -f install
google-chrome --version

```

21. Running everything successfully locally, from commandline.
22. Then opening the docker container from command line so i can access it via bash:

```
docker exec -u root -it jenkins bash
```

23. Installing all the previous things manually
24. Adding the "detached" and other flags to the chromedriver options.
25. Running the jenkins
26. SUCCESS!!!!!!!!
27. Cheering, finding again some meaning in life.
28. Taking back all the bad words I said about programming.
29. Man sad. Build successful. Man happy

Sorry for this informal type of documentation. But this was a mess. And I don't want to spend much time on it, cuz I have other more important things/projects to do.

P.S. when setting up chrome driver, pay attention to versions. Both chromedriver and chrome should have the same version (take a look here: [https://googlechromelabs.github.io/chrome-for-testing/#stable](https://googlechromelabs.github.io/chrome-for-testing/#stable))
