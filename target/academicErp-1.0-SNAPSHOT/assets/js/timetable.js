window.onload = fetch;
async function fetch(){
    let response = await fetch('api/students/timetable', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            email: document.getElementById('email'),
        })
    });
    let result = await response;
    console.log(result);
}
