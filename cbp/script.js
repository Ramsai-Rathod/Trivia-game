const questions = [
    {
        "question": "What is the capital of France?",
        "options": ["Berlin", "Madrid", "Paris", "Rome"],
        "answer": "Paris"
    },
    {
        "question": "Who wrote 'To Kill a Mockingbird'?",
        "options": ["Harper Lee", "Jane Austen", "J.K. Rowling", "Mark Twain"],
        "answer": "Harper Lee"
    },
    {
        "question": "What is the largest planet in our solar system?",
        "options": ["Earth", "Jupiter", "Mars", "Venus"],
        "answer": "Jupiter"
    },
    {
        "question": "Who painted the Mona Lisa?",
        "options": ["Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet"],
        "answer": "Leonardo da Vinci"
    },
    {
        "question": "What is the hardest natural substance on Earth?",
        "options": ["Gold", "Iron", "Diamond", "Platinum"],
        "answer": "Diamond"
    },
    {
        "question": "Who is known as the father of computers?",
        "options": ["Alan Turing", "Charles Babbage", "John von Neumann", "Thomas Edison"],
        "answer": "Charles Babbage"
    },
    {
        "question": "What is the smallest country in the world?",
        "options": ["Monaco", "Nauru", "Vatican City", "San Marino"],
        "answer": "Vatican City"
    },
    {
        "question": "What is the chemical symbol for gold?",
        "options": ["Au", "Ag", "Pb", "Fe"],
        "answer": "Au"
    },
    {
        "question": "In which year did the Titanic sink?",
        "options": ["1905", "1912", "1915", "1920"],
        "answer": "1912"
    },
    {
        "question": "Which planet is known as the Red Planet?",
        "options": ["Earth", "Jupiter", "Mars", "Venus"],
        "answer": "Mars"
    },
    {
        question: "What is 2 + 2?",
        options: ["3", "4", "5", "6"],
        answer: "4"
    }
];

let currentQuestionIndex = 0;
let score = 0;

document.addEventListener('DOMContentLoaded', (event) => {
    loadQuestion();
});

function loadQuestion() {
    const currentQuestion = questions[currentQuestionIndex];
    document.getElementById('questionTitle').innerText = `Question ${currentQuestionIndex + 1}`;
    document.getElementById('questionText').innerText = currentQuestion.question;

    const optionsContainer = document.getElementById('optionsContainer');
    optionsContainer.innerHTML = '';
     var i=1;
    currentQuestion.options.forEach(option => {
        const button = document.createElement('button');
        button.innerText =`${i++}.`+option;
        button.onclick = () => selectAnswer(option);
        optionsContainer.appendChild(button);
    });
}

function selectAnswer(selectedOption) {
    const currentQuestion = questions[currentQuestionIndex];
    if (selectedOption === currentQuestion.answer) {
        score++;
    }

    currentQuestionIndex++;

    if (currentQuestionIndex < questions.length) {
        loadQuestion();
    } else {
        endGame();
    }
}

function nextQuestion() {
    loadQuestion();
}

function endGame() {
    document.getElementById('scoreInput').value = score;
    document.getElementById('scoreForm').style.display = 'block';
    document.getElementById('question').style.display = 'none';
    document.getElementById('score').innerText = score;
}
