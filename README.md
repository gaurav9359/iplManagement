# iplManagement

## Do you watch the IPL?

Let's build our own system for managing the IPL tournament. Write a Java program (with Class Diagram), and develop a system for managing cricket tournament such that:

- There can be up to 10 teams participating in the tournament (similar to in the IPL)
- Tournament is T20 format
- Each team is assigned an unique home ground (venue)
- Every cricket match is played between two teams only
- Every team will have 12 players including the impact player in the playing squad
- System should record stats/performance of every player for each match
- It should have the ability to maintain the scoreboard with points, ranking for every team

Now today, extend the existing functionality and provide support for below functionality:

- Make adjustments in your codebase to now handle all the tournament type like IPL, T20 WorldCup, ODI WorldCup, World Test Campionship, etc
- Match format type can be T20, ODI, Test matches
- There will 12 players only in IPL tournament, but 11 players in all other tournament type
- Feel free to assume things as you go along!

The system should be able to answer global stats queries like:

- "Who is the highest wicket taker of all time?"
- "Who has scored maximum numbers of 50s?
- List out the teams who went to semi-finals?
- List out top 5 run scorers in the complete tournament?
- Program should print the winner of the tournament

Input:
-Who is the highest wicket taker of all time?

Output:
- Player Name
- No of wickets
