isPalindrome :: Int -> Bool
isPalindrome i = (reverse $ show i) == (show i)

candidates :: [Int]
candidates = [x*y | x<-[999,998..100], y<-[999,998..100]]

solve = maximum $ filter isPalindrome candidates

