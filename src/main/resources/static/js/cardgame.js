
var selectedCard = null;
const fieldWidth = 3;
const fieldHeight = 7;
const noCard = "No Card here";
const noTroop = "No Troop here";
var usedCards = [];

function getCoordFromCell(c)
{
    const r = Math.floor((c - 1) / fieldWidth);
    const l = (c - 1) % fieldWidth;

    return {
        row : r,
        lane : l
    };
}

function getCardString(s)
{
    var result = "";
    for (var x of s.split('\n'))
        result += x + "<br>";

    return result;
}

function selectCardFromHand(e)
{
    if (e.target.innerHTML != noCard)
        selectedCard = e.target;
}

function sendData()
{
    $.ajax({
        type : "POST",
        url : "/sendData",
        contentType : "application/json",
        data : JSON.stringify(usedCards),
        success : function(id) {
            // console.log("SUCCESS: ", id);
            document.location.href = '/cardgame';  
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        done : function(e) {
            console.log("DONE");
        }
    });
}

function selectCardFromField(e)
{
    if (selectedCard)
    {
        const cellPos = e.target.className.match(/\d+/)[0];
        const cellCoords = getCoordFromCell(cellPos);
        let isOccupied = false;
        for (let x of usedCards)
            if (x.destCoords.row === cellCoords.row && 
                x.destCoords.lane === cellCoords.lane)
                {
                    isOccupied = true;
                    break;
                }

        if (!isOccupied)
        {
            const selectCardPos = selectedCard.className.match(/\d+/)[0] - 1;
            const mid = Math.floor(fieldHeight * fieldWidth / 2);
            if (cellPos < mid)
            {
                if (selectedCard.className.includes("Up"))
                {
                    usedCards.push({
                        destCoords : cellCoords,
                        handPos : selectCardPos,
                        player : "Up"
                    });
                   replaceCard(selectedCard, e.target);
                   selectedCard = null;
                }
            }else if (cellPos >= mid + fieldWidth)
            {
                if (selectedCard.className.includes("Down"))
                {
                    usedCards.push({
                        destCoords : cellCoords,
                        handPos : selectCardPos,
                        player : "Down"
                    });
                    replaceCard(selectedCard, e.target);
                    selectedCard = null;
                }
            }
        }
    }
}

function loadPlayerUpHand()
{
    const mainParent = document.getElementsByClassName("parent")[0];
    var playerUpDivs = mainParent.getElementsByClassName("parentPlayerUp")[0].getElementsByTagName("div");
    for (var i = 0; i < playerUpDivs.length; ++i)
    {
        playerUpDivs[i].innerHTML = getCardString(playerUp.hand[i].printString);
        playerUpDivs[i].addEventListener("click", selectCardFromHand);
    }
}

function loadPlayerDownHand()
{
    const mainParent = document.getElementsByClassName("parent")[0];
    var playerDownDivs = mainParent.getElementsByClassName("parentPlayerDown")[0].getElementsByTagName("div");
    for (var i = 0; i < playerDownDivs.length; ++i)
    {
        playerDownDivs[i].innerHTML = getCardString(playerDown.hand[i].printString);
        playerDownDivs[i].addEventListener("click", selectCardFromHand);
    }

}

function replaceCard(handCard, fieldCard)
{
    fieldCard.innerHTML = handCard.innerHTML;
    handCard.innerHTML = "No Card here";
}

function loadField()
{
    console.log(usedCards);
    const mainParent = document.getElementsByClassName("parent")[0];
    var fieldDivs = mainParent.getElementsByClassName("parentField")[0].getElementsByTagName("div");
    for (let i = 0; i < fieldDivs.length; ++i)
    {
        const mid = Math.floor(fieldHeight * fieldWidth / 2);
        if (i < mid - 1 || i >= mid + fieldWidth - 1)
        {
            fieldDivs[i].innerHTML = noTroop;
            if (field)
            {
                if (field[i])
                    fieldDivs[i].innerHTML = getCardString(field[i].printString);
                else
                {
                    fieldDivs[i].innerHTML = noTroop;
                    fieldDivs[i].addEventListener("click", selectCardFromField);
                }
            }else
                fieldDivs[i].addEventListener("click", selectCardFromField);
        }
    }
}

function endRound(e)
{
    sendData();
    usedCards = [];
    init();
}

function initEndRound()
{
    const btn = document.getElementById("endRound");
    btn.addEventListener("click", endRound);
}

function init()
{
    loadPlayerUpHand();
    loadPlayerDownHand();
    loadField();
    initEndRound();
}

window.onload = init;