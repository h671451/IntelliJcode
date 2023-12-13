package bokanmeldese.eksamen23VbokanmeldserDat108.JavaScript;

public class Karakterv23 {
    #emnekode;
    #semester;
    #studenter = new Map();

    constructor(emnekode,semester){
    this.emnekode = emnekode;
    this.semester = semester;
    }

    addStudent(student){
        const {id,fornavn,etternavn, karakter} = student;

        if(!id || !fornavn || !etternavn || !karakter) return null;


        const idreg =  /^\p{Letter}\d{3}$/u;
        const karakterReg =  /^[A-F]$/;

        if(!karakterReg.test(karakter) || !idreg.test(id) ||this.#hasStudent(id)) return null;


        this.#studenter.set(id, {
        "fornavn":fornavn;
        "etternavn": etternavn;
        "karakter": karakter;
        })

        return student;
    }

    getStatisikk(karakter){
    const karakterfordeling = {};
    for(const k of "ABCDEF"){
        karakterfordeling[k] = 0;
    }
    for (const student of this.#studenter.values()){
        const karakter = student["karakter"];
        ++karakterfordeling[karakter];
    }

    const statstikk = {
        "emne": this.#emnekode;
        "semester": this.#semester;
        "karakterfordeling": karakterfordeling:
    }
    return statstikk;

    }




}
